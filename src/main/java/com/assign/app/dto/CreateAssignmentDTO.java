package com.assign.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "create_assignment")
public class CreateAssignmentDTO {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "PIN")
	private int pin;
	@Column(name = "COURSE")
	private String course;
	@Column(name = "TPOIC")
	private String topic;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "DEADLINE")
	private String deadLine;
	@Column(name = "UPLOAD_TYPE")
	private String uploadType;
	@Column(name = "EMIAL")
	private String emaiId;

	public CreateAssignmentDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUploadType() {
		return uploadType;
	}

	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}

	public String getEmaiId() {
		return emaiId;
	}

	public void setEmaiId(String emaiId) {
		this.emaiId = emaiId;
	}

	public String getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}

	@Override
	public String toString() {
		return "CreateAssignmentDTO [pin=" + pin + ", course=" + course + ", topic=" + topic + ", description="
				+ description + ", deadLine=" + deadLine + ", uploadType=" + uploadType + ", emaiId=" + emaiId + "]";
	}

}
