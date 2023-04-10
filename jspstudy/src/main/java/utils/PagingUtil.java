package utils;

public class PagingUtil {
	public static String pagingBlock(int totalCount, int pageSize, int blockSize, int pageNum, String reqUri) {

		String pagingRes = "";

		int totalPage = (int) Math.ceil((double) totalCount / pageSize);

		int pageTemp = (((pageNum - 1) / blockSize) * blockSize) + 1;
		// [첫번째] [이전페이지] 6 7 8 9 10 [다음페이지] [마지막 페이지]

		if (pageTemp != 1) {
			pagingRes = "<a href='" + reqUri + "?pageNum=1'>[first]</a>";
			pagingRes += "&nbsp;";
			pagingRes += "<a href='" + reqUri + "?pageNum=" + (pageTemp - 1) + "'>[prev block]</a>";
		}

		int blockCount = 1;
		while (blockCount <= blockSize && pageTemp <= totalPage) {
			if (pageTemp == pageNum) {
				pagingRes += "&nbsp;" + pageTemp + "&nbsp;";
			} else {
				pagingRes += "&nbsp;<a href='" + reqUri + "?pageNum=" + pageTemp + "'>" + pageTemp + "</a>&nbsp;";
			}
			pageTemp++;
			blockCount++;
		}

		if (pageTemp <= totalPage) {
			pagingRes += "<a href='" + reqUri + "?pageNum=" + (pageTemp) + "'>[next block]</a>";
			pagingRes += "&nbsp;";
			pagingRes += "<a href='" + reqUri + "?pageNum=14'>[last]</a>";
		}

		return pagingRes;

	}
	  public static String pagingCenter(int totalCount, int pageSize, int blockSize, int pageNum, String reqUri) {
	        String pagingRes = "";

	        int totalPage = (int)Math.ceil((double)totalCount/pageSize);

	        // [first] 1 2 3 4 5 [last]
	        int startPage = Math.max(pageNum - blockSize / 2, 1);
	        int endPage = Math.min(startPage + blockSize - 1, totalPage);

	        if(startPage != 1) {
	            pagingRes = "<a href='" + reqUri + "?pageNum=1'>[first]</a>";
	            pagingRes += "&nbsp;&nbsp;...&nbsp;&nbsp;";
	        }

	        for(int i = startPage; i <= endPage; i++) {
	            if(i == pageNum) {
	                pagingRes += "&nbsp;" + i + "&nbsp;";
	            } else {
	                pagingRes += "&nbsp;<a href='" + reqUri + "?pageNum=" + i + "'>" + i + "</a>&nbsp;";
	            }
	        }

	        if(endPage != totalPage) {
	            pagingRes += "&nbsp;&nbsp;...&nbsp;&nbsp;";
	            pagingRes += "<a href='" + reqUri + "?pageNum=" + totalPage + "'>[last]</a>";
	        }

	        return pagingRes;
	    }

	public static String pagingCenter(int totalCount, int pageSize, int pageNum, String reqUri) {
		String pagingRes = "";
		int totalPage = (int) Math.ceil((double) totalCount / pageSize);
		int pageTemp =  (pageNum>totalPage || pageNum < 1)? 1:pageNum; 
		// [첫번째] [이전페이지] 6 7 8 9 10 [다음페이지] [마지막 페이지]

		if (pageTemp != 1) {
			pagingRes = "<a href='" + reqUri + "?pageNum=1'>[first]</a>";
			pagingRes += "&nbsp;";
			pagingRes += "<a href='" + reqUri + "?pageNum=" + (pageTemp-5) + "'>[prev block]</a>";
		}

		int blockCount = 1;
		while (blockCount <= 5 && pageTemp <= totalPage) {
			if (pageTemp == pageNum) {
				pagingRes += "&nbsp;" + pageTemp + "&nbsp;";
			} else {
				pagingRes += "&nbsp;<a href='" + reqUri + "?pageNum=" + pageTemp + "'>" + pageTemp + "</a>&nbsp;";
			}
			pageTemp++;
			blockCount++;
		}

		if (pageTemp <= totalPage) {
			pagingRes += "<a href='" + reqUri + "?pageNum=" + (pageTemp) + "'>[next block]</a>";
			pagingRes += "&nbsp;";
			pagingRes += "<a href='" + reqUri + "?pageNum=14'>[last]</a>";
		}

		return pagingRes;

	}

}