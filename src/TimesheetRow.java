
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

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object clone() throws
            CloneNotSupportedException {
        return super.clone();
    }
}
