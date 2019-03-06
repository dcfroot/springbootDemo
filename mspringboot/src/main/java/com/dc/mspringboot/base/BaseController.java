package com.dc.mspringboot.base;

import com.dc.mspringboot.em.EnumError;
import com.sun.beans.editors.DoubleEditor;
import com.sun.beans.editors.IntegerEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Auther: dcf
 * @Date: 2019/2/21
 * @Description: 获取req,resp,session;
 *                 注册编辑器,参数过滤;
 *                 统一异常处理;
 */
@RestController
@Scope("prototype")//非单例，每次获得bean都会生成一个新的对象
public class BaseController {
    private static Logger logger = LoggerFactory.getLogger(BaseController.class);
    protected HttpSession session;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    @ModelAttribute //在运行此controller每个方法执行前被执行
    public void setReqAndResp(HttpServletRequest req,HttpServletResponse resp){
        this.request = req;
        this.response = resp;
        this.session = req.getSession();
    }

    /**
     * 注册编辑器
     * @Description: 参数过滤，
     * @auther: dcf
     * @date: 2019/2/21
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        //自定义IntegerEditor，将int参数传空值进行转换，变为0
        binder.registerCustomEditor(int.class,new IntegerEditor());
        //java1.8自带；
        binder.registerCustomEditor(Double.class, new DoubleEditor());
        //时间参数转换
       /* SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));*/

    }

    public class IntegerEditor extends PropertiesEditor {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if (text == null || text.equals("")) {
                text = "0";
            }
            setValue(Integer.parseInt(text));
        }

        @Override
        public String getAsText() {
            return getValue().toString();
        }
    }

    // 绑定变量名字和属性，参数封装进类
    @InitBinder("baseModel")
    public void initBinderBaseModel(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("baseModel.");
    }

    /**
     * @Description: 控制器统一异常处理
     * @auther: dcf
     * @date: 2019/2/21
     */
    @ExceptionHandler(Exception.class)
    public BusinessException handleException(Exception ex){
        BusinessException bsex = new BusinessException();
        if (ex instanceof BusinessException) {
            bsex = (BusinessException) ex;
            if (bsex.getCode() == 0) {
                bsex.setCode(1000);
            }
            logger.error("【业务异常】" + bsex.getMessage());
        } else {
            bsex.setMessage(EnumError.SYS_ERROR);
            bsex.setStackTrace(ex.getStackTrace());
            logger.error("【系统异常】" + bsex.getMessage(), ex);
        }
        response.setStatus(bsex.getCode());
        return bsex;
    }

}
