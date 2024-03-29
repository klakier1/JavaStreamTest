package streamTest;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class TimesheetRow implements Cloneable {

    private Integer idExternal;
    private Integer idLocal = 0;
    private Integer userId;
    private Date date;
    private Time from;
    private Time to;
    private Time customerBreak;
    private Time statutoryBreak;
    private String comments;
    private Integer projectId;
    private Integer companyId;
    private Boolean status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    /**
     * No args constructor for use in serialization
     */
    public TimesheetRow() {
    }

    /**
     * @param date
     * @param customerBreak
     * @param statutoryBreak
     * @param comments
     * @param userId
     * @param createdAt
     * @param companyId
     * @param from
     * @param idExternal
     * @param to
     * @param projectId
     * @param status
     * @param updatedAt
     */
    public TimesheetRow(Integer idExternal, Integer userId, Date date, Time from, Time to, Time customerBreak, Time statutoryBreak, String comments, Integer projectId, Integer companyId, Boolean status, Timestamp createdAt,
                        Timestamp updatedAt) {
        super();
        this.idExternal = idExternal;
        this.userId = userId;
        this.date = date;
        this.from = from;
        this.to = to;
        this.customerBreak = customerBreak;
        this.statutoryBreak = statutoryBreak;
        this.comments = comments;
        this.projectId = projectId;
        this.companyId = companyId;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getIdExternal() {
        return idExternal;
    }

    public void setIdExternal(Integer idExternal) {
        this.idExternal = idExternal;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public byte byteValue() {
		return userId.byteValue();
	}

	public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getFrom() {
        return from;
    }

    public void setFrom(Time from) {
        this.from = from;
    }

    public Time getTo() {
        return to;
    }

    public void setTo(Time to) {
        this.to = to;
    }

    public Time getCustomerBreak() {
        return customerBreak;
    }

    public void setCustomerBreak(Time customerBreak) {
        this.customerBreak = customerBreak;
    }

    public Time getStatutoryBreak() {
        return statutoryBreak;
    }

    public void setStatutoryBreak(Time statutoryBreak) {
        this.statutoryBreak = statutoryBreak;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((customerBreak == null) ? 0 : customerBreak.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((statutoryBreak == null) ? 0 : statutoryBreak.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimesheetRow other = (TimesheetRow) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (customerBreak == null) {
			if (other.customerBreak != null)
				return false;
		} else if (!customerBreak.equals(other.customerBreak))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statutoryBreak == null) {
			if (other.statutoryBreak != null)
				return false;
		} else if (!statutoryBreak.equals(other.statutoryBreak))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object clone() throws
            CloneNotSupportedException {
        return super.clone();
    }

	@Override
	public String toString() {
		return "TimesheetRow [idExternal=" + idExternal + ", idLocal=" + idLocal + ", updatedAt=" + updatedAt + "]";
	}
    
    
}
