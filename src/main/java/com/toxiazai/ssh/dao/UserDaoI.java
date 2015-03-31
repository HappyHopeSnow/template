package com.toxiazai.ssh.dao;

import com.toxiazai.ssh.entity.SysUser;

import java.io.Serializable;

/**
 * @author Judas.n 2014年4月6日 22:49:12
 */
public interface UserDaoI {
	public Serializable saveUser(SysUser user);
	public SysUser getUser(String userId);
}
