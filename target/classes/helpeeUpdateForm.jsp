<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Header.jsp"%>
    <!-- 본문 -->



    <div class="container">
        <div class="row writeForm ">
            <div class="col-md-3 order-1 order-md-1 d-flex justify-content-center">
                <img class="profile-img-box" src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
                    alt="profileImage">
            </div>
            <div class="col-md-9 order-2 order-md-2">
                <div class="media-body">
                    <div class="row">
                        <div class="col-md-6">
                            <h3 class="name-box">${sessionScope.userName}&nbsp;</h3>
                        </div>
                        <div class="col-md-6 d-flex flex-row-reverse">
                             ${sessionScope.userGender}&nbsp;
                        </div>
                        <div class="col-12">
                        ${sessionScope.userPhone}&nbsp;
                    </div>
                    </div>
       
                    <form class="helper-write-form"  action="helpeeUpdate.do" method="post">
                        <div class="row">
                            <div class="col-md-6 my-1">
                            <input name="uno" type="hidden" value="${sessionScope.userNumber}"/>
                            <input name="eno" type="hidden" value="${helpee.eno}"/>
                                <input name="edate" id="date-result" type="hidden" value="${helpee.edate}"/>
                                <input type="text" id="datepicker2" class="form-control"
                                    placeholder="${helpee.edate}" autocomplete="off">
                            </div>
                            <div class="col-md-6 my-1">
                                <select class="custom-select" disabled="disabled" name="lno" value="${helpee.lno}">
                                    <option selected>Choose your language</option>
                               		<c:forEach items="${languageList}" var="language">
                                    <option value="${language.lno}"
											<c:if test="${helpee.lno eq language.lno}">selected</c:if>>${language.language}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 my-1">
                                <select class="custom-select" name="eplace" value="${helpee.eplace}">
                                    <option selected>Choose your area</option>
                                   <c:forEach items="${seoulList}" var="seoul">
										<option value="${seoul.dno}"
											<c:if test="${helpee.eplace eq seoul.dno}">selected</c:if>>${seoul.district}</option>
									</c:forEach>
                                </select>
                            </div>
                            <div class="col-md-6 d-flex flex-column my-1">

                                <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                    <label class="btn btn-secondary checkbox-btn">
                                       <input name="moving" type="checkbox" class="service" value="1" 
                                        	<c:if test="${helpee.moving eq 1}">checked</c:if>> 
                                        	moving
                                    </label>
                                    <label class="btn btn-secondary checkbox-btn">
                                        <input name="hospital" type="checkbox" class="service" value="1" 
                                        	<c:if test="${helpee.hospital eq 1}">checked</c:if>> 
                                        	hospital
                                    </label>
                                    <label class="btn btn-secondary checkbox-btn">
                                        <input name="immigration" type="checkbox" class="service" value="1" 
                                        	<c:if test="${helpee.immigration eq 1}">checked</c:if>> 
                                        	immigration
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group my-3">
                            <label for="detailReview">Additional Infomation</label>
                            <textarea id="detailReview" name="e_intro" class="form-control form-control-write"
                                rows="5" value="${helpee.e_intro}">${helpee.e_intro}</textarea>
                        </div>
                        <button type="submit" class="btn btn-primary helper-button-main">Submit!</button>
                    </form>
                </div>

            </div>

        </div>
    </div>

<%@ include file="Footer.jsp"%>


<script>
var datePicker = new Lightpick({
	  field: document.getElementById('datepicker2'),
	  singleDate: true,
	  selectForward: true,
	  onSelect: function (start, end) {
	    var str = '';
	    str += start ? start.format('YYYY-MM-DD') + '' : '';
	    document.getElementById('date-result').innerHTML = str;
	    document.getElementById('date-result').value = str;

	  }
	});
</script>