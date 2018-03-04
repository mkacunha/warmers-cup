package br.com.mkacunha.warmerscup.warmerscupserver.domain.worker;

import java.io.Serializable;

public class WorkerDTO implements Serializable{

	private static final long serialVersionUID = -8357557244569148077L;

	private Long id;

	private String rfid;

	private String name;

	private String email;

	private boolean isRemote;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isRemote() {
		return isRemote;
	}

	public void setRemote(boolean remote) {
		isRemote = remote;
	}
}
