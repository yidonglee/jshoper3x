package com.jshop.entity;

// Generated 2013-8-27 20:25:25 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AuthorityT generated by hbm2java
 */
@Entity
@Table(name = "authority_t", catalog = "jshoper3")
public class AuthorityT implements java.io.Serializable {

	private String autid;
	private String chpagename;
	private String enpagename;
	private String operate;
	private Date createtime;
	private String roleid;

	public AuthorityT() {
	}

	public AuthorityT(String autid, String chpagename, String enpagename,
			String operate, Date createtime) {
		this.autid = autid;
		this.chpagename = chpagename;
		this.enpagename = enpagename;
		this.operate = operate;
		this.createtime = createtime;
	}

	public AuthorityT(String autid, String chpagename, String enpagename,
			String operate, Date createtime, String roleid) {
		this.autid = autid;
		this.chpagename = chpagename;
		this.enpagename = enpagename;
		this.operate = operate;
		this.createtime = createtime;
		this.roleid = roleid;
	}

	@Id
	@Column(name = "AUTID", unique = true, nullable = false, length = 20)
	public String getAutid() {
		return this.autid;
	}

	public void setAutid(String autid) {
		this.autid = autid;
	}

	@Column(name = "CHPAGENAME", nullable = false, length = 45)
	public String getChpagename() {
		return this.chpagename;
	}

	public void setChpagename(String chpagename) {
		this.chpagename = chpagename;
	}

	@Column(name = "ENPAGENAME", nullable = false, length = 100)
	public String getEnpagename() {
		return this.enpagename;
	}

	public void setEnpagename(String enpagename) {
		this.enpagename = enpagename;
	}

	@Column(name = "OPERATE", nullable = false, length = 1)
	public String getOperate() {
		return this.operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATETIME", nullable = false, length = 0)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "ROLEID", length = 20)
	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

}
