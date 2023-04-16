<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개발중임</title>
<link rel="styleSheet" href="../projectResources/RecipeView.css">

</head>
<body>
	<div class="recipeView">
		<div class="recipe_summary">
			<h3>${recipeDto.recipe_name}</h3>
			<div class="summary_in">${recipeDto.recipe_desc}</div>
			<div class="summary_info">
				<span>${recipeDto.amount_portion}</span>&nbsp&nbsp <span>${recipeDto.cooking_time}</span>&nbsp&nbsp
				<span>${recipeDto.difficulty}</span>
			</div>

			<div class="recipe_ingredient">
				<div class="recipe_title">재료</div>
				<div class="recipe_type">
					<ul>
						<c:set var="has1" value="false" />
						<c:set var="has2" value="false" />
						<c:forEach var="ingre" items="${ingreList}">
							<c:if test="${ingre.ingredient_type=='재료' && !has1}">
								<c:set var="has1" value="true" />
								<span>재료</span>
							</c:if>
							<c:if test="${ingre.ingredient_type=='양념' && !has2}">
								<c:set var="has2" value="true" />
								<span>양념</span>
							</c:if>
							<li>${ingre.ingredient_name}</li>
							<li>${ingre.amount}</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="recipe_step">
				<div class="step_title">조리순서</div>
					<div class="stepDiv1">
						<ul>
							<c:forEach var="stepList" items="${stepList}">
								<div class="step_middle">${stepList.step_desc}</div>
								<div class="step_right"><img src=""/></div>
							</c:forEach>
						</ul>
					</div>
			</div>
			<br> <br>

			<div class="recipe_review">
				<div class="review_title">
					<h3>
						요리 후기 <span>${ratingCount}</span>
					</h3>
					<c:forEach var="ratingList" items="${ratingList}">
					<div class="review_user_info">
						<h4>${ratingList.user_nickname}</h4>
					</div>
					<div class="review_content">
						<p>${ratingList.rating_content}</p>
					</div>
					</c:forEach>
				</div>
			</div>
			<br> <br>

			<div class="recipe_comment">
				<div class="comment_title">
					<div class="review_title">
						<h3>
							댓글<span>${commentCount}</span>
						</h3>
						<c:forEach var="commentList" items="${commentList}">
						<div class="comment_user_info">
							<h4>${commentList.user_nickname}</h4>
						</div>
						<div class="comment_content">${commentList.comment_content}</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>