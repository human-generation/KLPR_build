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
                    </div>
                    <div class="writeFormContainer">
                        <div>
                           ${sessionScope.userPhone}&nbsp;
                        </div>
                        
                    </div>
                    <form autocomplete="off" class="helper-write-form"  action="helperUpdate.do" method="post">
                        <div class="row">
                            <div class="col-md-6 my-1">
                            <input name="uno" type="hidden" value="${sessionScope.userNumber}"/>
                            <input name="rno" type="hidden" value="${helper.rno}"/> 
                            <input name="sta" type="hidden" id="date-result-start" value="${helper.sta}"/>
							<input name="end" type="hidden" id="date-result-end" value="${helper.end}"/>                              
                            <input type="text" id="datepicker1" class="form-control"
                                    placeholder="${helper.sta} ~ ${helper.end}" autocomplete="off">
                            </div>
                            <div class="col-md-6 my-1">
                                <select class="custom-select" disabled="disabled" name="lno" value="${helper.lno}">
                                    <option selected>Choose your language</option>
                               		<c:forEach items="${languageList}" var="language">
                                    <option value="${language.lno}"
											<c:if test="${helper.lno eq language.lno}">selected</c:if>>${language.language}</option>
									</c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 my-1">
                                <select class="custom-select" name="rplace" value="${helper.rplace}">
                                    <option selected>Choose your area</option>
                                   <c:forEach items="${seoulList}" var="seoul">
										<option value="${seoul.dno}"
											<c:if test="${helper.rplace eq seoul.dno}">selected</c:if>>${seoul.district}</option>
									</c:forEach>
                                </select>
                            </div>
                            <div class="col-md-6 d-flex flex-column my-1">

                                <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                    <label class="btn btn-secondary checkbox-btn">
                                       <input name="moving" class="service" type="checkbox" value="1"
											<c:if test="${helper.moving eq 1}">checked</c:if>>
											moving
                                    </label>
                                    <label class="btn btn-secondary checkbox-btn">
                                        <input name="hospital" class="service" type="checkbox" value="1"
											<c:if test="${helper.hospital eq 1}">checked</c:if>>
											hospital
                                    </label>
                                    <label class="btn btn-secondary checkbox-btn">
                                       <input name="immigration" class="service" type="checkbox" value="1"
											<c:if test="${helper.immigration eq 1}">checked</c:if>>
											immigration
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group my-3">
                            <label for="detailReview">Additional Infomation</label>
                            <textarea id="detailReview" name="r_intro" class="form-control form-control-write"
                                rows="5" value="${helper.r_intro}">${helper.r_intro}</textarea>
                        </div>
                        <button type="submit" class="btn btn-primary helper-button-main">Submit!</button>
                    </form>
                </div>

            </div>

        </div>
    </div>

<%@ include file="Footer.jsp"%>

<script>
var staEndPicker = new Lightpick({
	  field: document.getElementById('datepicker1'),
	  singleDate: false,
	  selectForward: true,
	  onSelect: function (start, end) {
	    var str = '';
	    var str2 = '';
	    str += start ? start.format('YYYY-MM-DD') + '' : '';
	    str2 += end ? end.format('YYYY-MM-DD') : '...';
	    document.getElementById('date-result-start').innerHTML = str;
	    document.getElementById('date-result-start').value = str;
	    document.getElementById('date-result-end').innerHTML = str2;
	    document.getElementById('date-result-end').value = str2;
	  }
	});
</script>