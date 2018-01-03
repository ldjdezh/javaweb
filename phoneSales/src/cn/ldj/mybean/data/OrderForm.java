package cn.ldj.mybean.data;

public class OrderForm {
	private Integer oid;
	private User user;
	private MobileForm mobileForm;
	private String mess;
	private Integer num;
	private double sum;
	private Integer status;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MobileForm getMobileForm() {
		return mobileForm;
	}

	public void setMobileForm(MobileForm mobileForm) {
		this.mobileForm = mobileForm;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

}
