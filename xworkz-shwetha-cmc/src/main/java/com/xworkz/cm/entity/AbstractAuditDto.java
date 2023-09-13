package com.xworkz.cm.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class AbstractAuditDto implements Serializable{
	
	private String createdby;
	private LocalDateTime createddate;
	private String updatedby;
	private LocalDateTime updateddate;

}
