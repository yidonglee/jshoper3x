package com.jshop.action.frontstage.usercenter;

import java.net.UnknownHostException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.backstage.template.DataCollectionTAction;
import com.jshop.action.backstage.tools.BaseTools;
import com.jshop.entity.UserT;
import com.jshop.entity.VouchersT;
import com.jshop.service.VouchersTService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
public class MyVouchersAction extends ActionSupport {
	private VouchersTService vouchersTService;
	private DataCollectionTAction dataCollectionTAction;
	private String cp;

	@JSON(serialize=false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}
	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}
	@JSON(serialize=false)
	public VouchersTService getVouchersTService() {
		return vouchersTService;
	}
	public void setVouchersTService(VouchersTService vouchersTService) {
		this.vouchersTService = vouchersTService;
	}
	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 查询用户的抵用券
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	@Action(value = "findUserVouchers", results = { 
			@Result(name = "success",type="freemarker",location = "WEB-INF/theme/default/shop/vouchers.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/login.html")
	})
	public String findUserVouchers(){
		UserT user = (UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if (user != null) {
			int currentPage = 1;
			int lineSize = 50;
			try {
				currentPage = Integer.parseInt(this.getCp());
			} catch (Exception e) {
			}
			List<VouchersT> list = this.getVouchersTService().findUserVouchers(user.getUserid(), currentPage, lineSize);
			int allRecorders = this.getVouchersTService().countfindUserVouchers(user.getUserid());
			//路径获取
			ActionContext.getContext().put("basePath", this.getDataCollectionTAction().getBasePath());
			//获取我的收藏
			ActionContext.getContext().put("vouchers", list);
			//获取导航数据
			ActionContext.getContext().put("siteNavigationList", this.getDataCollectionTAction().findSiteNavigation());
			//获取商城基本数据
			ActionContext.getContext().put("jshopbasicinfo", this.getDataCollectionTAction().findJshopbasicInfo());
			//获取页脚分类数据
			ActionContext.getContext().put("footcategory", this.getDataCollectionTAction().findFooterCateogyrT());
			//获取页脚文章数据
			ActionContext.getContext().put("footerarticle", this.getDataCollectionTAction().findFooterArticle());
			return SUCCESS;

		}
		return INPUT;

	}
}
