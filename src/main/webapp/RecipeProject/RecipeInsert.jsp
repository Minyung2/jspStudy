<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삽입술</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<script>
	
</script>
</head>
<body>
	<div class="insert_form">
		<div class="insert_form_title">
			<b>레시피 등록</b>
		</div>
		<div class="insert_summary">
			<div class="summary_title">
				레시피 제목 <input type="text" style="width: 610px;"
					placeholder="예 ) 소고기 미역국 끓이기">
			</div>
			<div class="summary_describe">
				요리 소개 <input type="text"
					style="height: 100px; width: 610px; resize: none;"
					placeholder="이 레시피의 탄생배경을 적어주세요. 예) 남편의 생일을 맞아 소고기 미역국을 끓여봤어요. 어머니로부터 배운 미역국 레시피를 남편의 입맛에 맞게 고안했습니다.">
			</div>
			<div class="summary_category">
				<b>카테고리</b> <select name="select_category_4" id="select_category_4">
					<optgroup>
						<option>종류별</option>
						<option value="1">밑반찬</option>
						<option value="2">메인반찬</option>
						<option value="3">어저구</option>
						<option value="4">저쩌구</option>
					</optgroup>
				</select> <select name="select_category_3" id="select_category_3">
					<optgroup>
						<option>상황별</option>
						<option value="1">일상</option>
						<option value="2">단백질</option>
						<option value="3">헬창</option>
						<option value="4">근손실방지</option>
					</optgroup>
				</select> <select name="select_category_2" id="select_category_2">
					<optgroup>
						<option>방법별</option>
						<option value="1">볶음</option>
						<option value="2">끓이기</option>
						<option value="3">부침</option>
						<option value="4">근육조지기</option>
					</optgroup>
				</select> <select name="select_category_1" id="select_category_1">
					<optgroup label="재료별">
						<option>재료별</option>
						<option value="1">소고기</option>
						<option value="2">돼지고기류</option>
						<option value="3">단백질류</option>
						<option value="4">프로틴류</option>
					</optgroup>
				</select>
			</div>
			<br>
			<div class="summary_recipe_info">
				<p>
					<b>요리정보</b>
				</p>
				인원 <select name="select_info_1" id="select_info_1">
					<optgroup label="인원">
						<option>인원</option>
						<option value="1">1인분</option>
						<option value="2">2인분</option>
						<option value="3">3인분</option>
						<option value="4">4인분</option>
						<option value="5">5인분</option>
						<option value="6">6인분 이상</option>
					</optgroup>
				</select> 시간 <select name="select_info_2" id="select_info_2">
					<optgroup label="시간">
						<option>시간</option>
						<option value="1">5분 이내</option>
						<option value="2">10분 이내</option>
						<option value="3">15분 이내</option>
						<option value="4">20분 이내</option>
						<option value="5">30분 이내</option>
						<option value="6">60분 이내</option>
						<option value="7">90분 이내</option>
						<option value="8">2시간 이내</option>
						<option value="9">2시간 이상</option>
					</optgroup>
				</select> 난이도 <select name="select_info_3" id="select_info_3">
					<optgroup label="난이도">
						<option>난이도</option>
						<option value="1">아무나</option>
						<option value="2">초급</option>
						<option value="3">중급</option>
						<option value="4">고급</option>
						<option value="5">신의 경지</option>

					</optgroup>
				</select>
			</div>
		</div>
		<br>
		<br>
		<br>
		<div class="insert_ingredients">
			<span style="width: 100%;">재료가 남거나 부족하지 않도록 정확한 계량정보를 적어주세요.</span>
			<div class="ingredient_group_div">
				<li style="list-style-type: none;">
					<p>
						<input type="text" name="ingredient_group_title_1" value="재료"
							style="font-weight: bold; font-size: 18px; width: 210px;"/>
					</p>
					<ul id="ingredient_group_list">
						<li style="list-style-type: none" id="ingredient_text_list1">
							<input type="text" style="width: 200px;" placeholder="예)돼지고기"></input> 
							<input type="text" style="width: 200px;" placeholder="예)300g"></input>
						</li>
						<li style="list-style-type: none" id="ingredient_text_list2">
							<input type="text" style="width: 200px;" placeholder="예)양배추"></input> 
							<input type="text" style="width: 200px;" placeholder="예)1/2개"></input>
						</li>
						<li style="list-style-type: none" id="ingredient_text_list3"> 
							<input type="text" style="width: 200px;" placeholder="예)참기름"></input> 
							<input type="text" style="width: 200px;" placeholder="예)1T"></input>
						</li>
					</ul>
				</li>
			</div>
		</div>
		<div class="add_ingredient_group">
			<span>※ 양념, 양념장, 소스, 드레싱, 토핑, 시럽, 육수 밑간 등으로 구분해서 작성해주세요.</span><br>
			<button type="button" id="addIngredientGroup">재료/양념 추가</button>
		</div>
		<br><br>
		<div class="recipe_step_form">
			<div class="recipe_step_title">
				<input type="file" name="file" id="multifile_1" file_gubun="step" style="display: none;" multiple="">
				<p class="cont_tit3" style="font-weight: bold">
					요리순서
				</p>
			</div>
			<div class="recipe_step_guide">
				<span class="guide mag_b_15"><b>요리의 맛이 좌우될 수 있는 중요한 부분은 빠짐없이 적어주세요.</b><br>
					예) 10분간 익혀주세요 ▷ 10분간 약한불로 익혀주세요.<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;마늘편은 익혀주세요 ▷ 마늘편을 충분히 익혀주셔야 매운 맛이 사라집니다.<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;꿀을 조금 넣어주세요 ▷ 꿀이 없는 경우, 설탕 1스푼으로 대체 가능합니다.
	  			</span>
			</div>
			<div class="recipe_stpe_detail">
				<p>Step1</p>
				<textarea placeholder="씨발 개어려웡"></textarea>
				<img id="stepPhotoHolder_1" onclick="browseStepFile(1)" src="" width="160" height="160" style="cursor:pointer">
			</div>
			<br>
			<div class="recipe_step_donePhotos">
				<p style="font-weight: bold; font-size: 15px">요리 완성 사진</p>
				<img id="stepPhotoHolder_1" onclick="StepDoneFile(1)" src="" width="160" height="160" style="cursor:pointer">
			</div>
		</div>
		
		<div class="recipe_tips">
			<p>요리팁</p>
		</div>
		
		<button type="submit">저장</button>
		<button type="reset">초기화</button>
		<button tpye="button" onclick="">취소</button>
	</div> 
	
	<script>
	var ingredients = [
	    {
	        name: "돼지고기",
	        amount: "300g"
	    },
	    {
	        name: "양배추",
	        amount: "1/2개"
	    },
	    {
	        name: "참기름",
	        amount: "1T"
	    },
	    {
	        name: "소금",
	        amount: "1/4T"
	    }
	];
	var currentIngredientIndex = 0; // 현재 표시할 ingredients 배열의 인덱스
	var currentIdIndex = 4; // 현재 부여할 id 값의 시작 인덱스

	$(function(){
	    $('#addIngredientGroup').on('click',function(){
	        // ingredients 배열에서 현재 인덱스의 name과 amount 값을 가져와 placeholder에 대입
	        var currentIngredient = ingredients[currentIngredientIndex];
	        var newListItem = $('<li style="list-style-type: none"><input type="text" style="width: 200px;" placeholder="예)' + currentIngredient.name + '"></input> <input type="text" style="width: 200px;" placeholder="예)' + currentIngredient.amount + '"></input></li>');
	        
	        // id 값 부여
	        newListItem.attr('id', 'ingredient_text_list' + currentIdIndex);
	        currentIdIndex++;
	        
	        $('#ingredient_group_list').append(newListItem);
	        
	        // 다음에 대입할 인덱스 계산
	        currentIngredientIndex = (currentIngredientIndex + 1) % ingredients.length;
	    });
	});
	
	</script>
</body>
</html>