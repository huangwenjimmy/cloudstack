/**
 *  Copyright (C) 2010 Cloud.com, Inc.  All rights reserved.
 * 
 * This software is licensed under the GNU General Public License v3 or later.
 * 
 * It is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package com.cloud.vm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cloud.hypervisor.Hypervisor.HypervisorType;

/**
 * SecondaryStorageVmVO domain object
 */

@Entity
@Table(name="secondary_storage_vm")
@PrimaryKeyJoinColumn(name="id")
@DiscriminatorValue(value="SecondaryStorageVm")
public class SecondaryStorageVmVO extends VMInstanceVO implements SecondaryStorageVm {

    @Column(name="gateway", nullable=false)
    private String gateway;
    
    @Column(name="dns1")
    private String dns1;
    
    @Column(name="dns2")
    private String dns2;

    @Column(name="public_ip_address", nullable=false)
    private String publicIpAddress;
    
    @Column(name="public_mac_address", nullable=false)
    private String publicMacAddress;
    
    @Column(name="public_netmask", nullable=false)
    private String publicNetmask;
    
    @Column(name="domain", nullable=false)
    private String domain;
    
    @Column(name="guid", nullable=false)
    private String guid;
    
    @Column(name="nfs_share", nullable=false)
    private String nfsShare;
    
    
    @Column(name="ram_size", updatable=false, nullable=false)
    private int ramSize;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update", updatable=true, nullable=true)
    private Date lastUpdateTime;
    
    
    
    public SecondaryStorageVmVO(long id, long serviceOfferingId, String name, long templateId, HypervisorType hypervisorType, long guestOSId, long dataCenterId, 
    							long domainId, long accountId) {
	    super(id, serviceOfferingId, name, name, Type.SecondaryStorageVm, templateId, hypervisorType, guestOSId, domainId, accountId, true);
	}
    
    protected SecondaryStorageVmVO() {
        super();
    }

    public void setGateway(String gateway) {
    	this.gateway = gateway;
    }
    
    public void setDns1(String dns1) {
    	this.dns1 = dns1;
    }
    
    public void setDns2(String dns2) {
    	this.dns2 = dns2;
    }
    
    public void setDomain(String domain) {
    	this.domain = domain;
    }
    
    public void setPublicIpAddress(String publicIpAddress) {
    	this.publicIpAddress = publicIpAddress;
    }
    
    public void setPublicNetmask(String publicNetmask) {
    	this.publicNetmask = publicNetmask;
    }
    
    public void setPublicMacAddress(String publicMacAddress) {
    	this.publicMacAddress = publicMacAddress;
    }
    
    public void setRamSize(int ramSize) {
    	this.ramSize = ramSize;
    }
    
    public void setLastUpdateTime(Date time) {
    	this.lastUpdateTime = time;
    }
  
    @Override
	public String getGateway() {
		return this.gateway;
	}
	
    @Override
	public String getDns1() {
    	return this.dns1;
	}
	
    @Override
	public String getDns2() {
    	return this.dns2;
	}
	
    @Override
	public String getPublicIpAddress() {
    	return this.publicIpAddress;
	}
	
    @Override
	public String getPublicNetmask() {
    	return this.publicNetmask;
	}
	
    @Override
	public String getPublicMacAddress() {
		return this.publicMacAddress;
	}
    

    @Override
    public String getDomain() {
    	return this.domain;
    }
	
    @Override
	public int getRamSize() {
    	return this.ramSize;
    }

   @Override
    public Date getLastUpdateTime() {
    	return this.lastUpdateTime;
    }

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getGuid() {
		return guid;
	}

	public void setNfsShare(String nfsShare) {
		this.nfsShare = nfsShare;
	}

	public String getNfsShare() {
		return nfsShare;
	}
}
