package com.qa.Rest.POJO;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

/*@Value*/
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Search {

    @JsonProperty("ccsIdOrContNoOrContApptNo")
    private String ccsIdOrContNoOrContApptNo;
    @JsonProperty("apptDateFrom")
    private String apptDateFrom;
    @JsonProperty("apptDateTo")
    private String apptDateTo;
    /*@JsonProperty("lineId")
    private LineId lineId;*/
    @JsonProperty("lineId")
    private String lineId [];
    /*@JsonProperty("appointmentType")
    public AppointmentType appointmentType;*/
    @JsonProperty("appointmentType")
    private String appointmentType [];
    @JsonProperty("truckingCompanyId")
    private  String truckingCompanyId;
    @JsonProperty("truckingCompanyName")
    private String truckingCompanyName;
    @JsonProperty("subContractCompanyId")
    private String subContractCompanyId;
    @JsonProperty("subContractCompanyName")
    private String subContractCompanyName;
    @JsonProperty("bookingNo")
    private String bookingNo;
    @JsonProperty("passNo")
    private String passNo;
    @JsonProperty("truckId")
    private String truckId;
    @JsonProperty("driverPortPassId")
    private String driverPortPassId;
    @JsonProperty("grade")
    private String grade;
    /*@JsonProperty("status")
    private Status status;*/
    @JsonProperty("status")
    private String status [];
    @JsonProperty("truckVisitAppointmentNo")
    private String truckVisitAppointmentNo;
    @JsonProperty("clientCode")
    private String clientCode;
    @JsonProperty("site")
    private String site;
    @JsonProperty("pageNo")
    private String pageNo;
    @JsonProperty("pageSize")
    private String pageSize;
    @JsonProperty("order")
    private String order;
    @JsonProperty("referenceNo")
    private String referenceNo;
    private String a [];



    /*public String getCcsIdOrContNoOrContApptNo() {
        return ccsIdOrContNoOrContApptNo;
    }

}*/

    /*private String ccsIdOrContNoOrContApptNo;
    private String apptDateFrom;
    private String apptDateTo;
    private String lineId;
    private String appointmentType;;
    private String truckingCompanyId;
    private String truckingCompanyName;
    private String subContractCompanyId;
    private String subContractCompanyName;
    private String bookingNo;
    private String passNo;
    private String truckId;
    private String driverPortPassId;
    private String grade;
    private String status;
    private String truckVisitAppointmentNo;
    private String clientCode;
    private String site;
    private String pageNo;
    private String pageSize;
    private String order;*/



    public String getCcsIdOrContNoOrContApptNo() {
        return ccsIdOrContNoOrContApptNo;
    }

    public void setCcsIdOrContNoOrContApptNo(String ccsIdOrContNoOrContApptNo) {
        this.ccsIdOrContNoOrContApptNo = ccsIdOrContNoOrContApptNo;
    }

    public String getApptDateTo() {
        return apptDateTo;
    }

    public void setApptDateTo(String apptDateTo) {
        this.apptDateTo = apptDateTo;
    }

    /*public LineId getLineId() {
        return lineId;
    }

    public void setLineId(LineId lineId) {
        this.lineId = lineId;
    }

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }*/

    public String getTruckingCompanyId() {
        return truckingCompanyId;
    }

    public void setTruckingCompanyId(String truckingCompanyId) {
        this.truckingCompanyId = truckingCompanyId;
    }

    public String getTruckingCompanyName() {
        return truckingCompanyName;
    }

    public void setTruckingCompanyName(String truckingCompanyName) {
        this.truckingCompanyName = truckingCompanyName;
    }

    public String getSubContractCompanyId() {
        return subContractCompanyId;
    }

    public void setSubContractCompanyId(String subContractCompanyId) {
        this.subContractCompanyId = subContractCompanyId;
    }

    public String getSubContractCompanyName() {
        return subContractCompanyName;
    }

    public void setSubContractCompanyName(String subContractCompanyName) {
        this.subContractCompanyName = subContractCompanyName;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getPassNo() {
        return passNo;
    }

    public void setPassNo(String passNo) {
        this.passNo = passNo;
    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public String getDriverPortPassId() {
        return driverPortPassId;
    }

    public void setDriverPortPassId(String driverPortPassId) {
        this.driverPortPassId = driverPortPassId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

   /* public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }*/

    public String getTruckVisitAppointmentNo() {
        return truckVisitAppointmentNo;
    }

    public void setTruckVisitAppointmentNo(String truckVisitAppointmentNo) {
        this.truckVisitAppointmentNo = truckVisitAppointmentNo;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String[] getA() {
        return a;
    }

    public void setA(String[] a) {
        this.a = a;
    }

    public String[] getLineId() {
        return lineId;
    }

    public void setLineId(String[] lineId) {
        this.lineId = lineId;
    }

    public String[] getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String[] appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }
}


   /* public String SearchValue()
    {
        setCcsIdOrContNoOrContApptNo("");
        setApptDateTo("");
        setLineId("");
        setAppointmentType("DOM");
        setSubContractCompanyId("");
        setBookingNo("");
        setPageNo("");
        setTruckId("");
        setTruckingCompanyId("");
        setDriverPortPassId("");
        setGrade("");
        setStatus("");
        setTruckVisitAppointmentNo("");
        setClientCode("");
        setSite("");
        setPageNo("");
        setPageSize("");
        setOrder("");
*/






