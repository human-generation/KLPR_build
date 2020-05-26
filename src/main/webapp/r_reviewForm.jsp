<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(헬퍼가)헬피 리뷰 등록</title>
</head>
<body>

<form action="r_review.do" method="post">
			<table border="1">
				<tr>
					<td>헬퍼 평점</td>
					<td><input type="text" name="rscore" value="${r_review.rscore}"></td>
				</tr>
				<tr>
					<td>상세코멘트 :</td>
					<td><input type="text" name="rcomment" value="${r_review.rcomment}"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="등록">
					</td>
				</tr>
			</table>
		</form>
		
		
		
		
		
		
		
		
		<!-- Additional Review Modal-->
    <div class="modal fade" id="reviewModal" tabindex="-1" role="dialog" aria-labelledby="reviewModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalLabel">Reivew </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="modal-body">
                    <form class="review-form" action="review.do" method="POST">
                        <div class="row">
                            <div class="col-5">
                                <img class="mr-3"
                                    src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
                                    alt="profileImage">
                            </div>
                            <div class="col-7">
                                <div class="media-body">
                                    <a href="#" class="badge badge-primary helpee-button-main">이사</a>
                                    <a href="#" class="badge badge-primary helpee-button-main">병원</a>
                                    <h4>Doja Cat</h4>
                                    <div class="btn">{mdate}</div>
                                </div>
		                            </div>
                        </div>
                        <div class="form-group">
                            <label for="reviewScore">평점남기기</la
                            bel>
                            <select name="rscore" class="form-control" required>
                                <option value="5">5</option>
                                <option value="4">4</option>
                                <option value="3">3</option>
                                <option value="2">2</option>
                                <option value="1">1</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="detailReview">Review your match</label>
                            <textarea name="rcomment" class="form-control" rows="3"></textarea>
                        </div>

                        <button type="submit" class="btn btn-primary helper-button-main">Submit your review!</button>
                    </form>

                </div>
            </div>
        </div>
    </div>
		
		
		
		
		


</body>
</html>