package com.dg.s10.util;

public class Pager {
	
	private String kind;
	private String search;
	
	//long의 l을 대문자로 쓰는이유 null을 받기 위해서
	private Long pn;
	
	//한페이지에 출력할 글의 갯수
	private Long perPage;
	
	private Long perBlock;

	private Long startRow;
	private Long lastRow;

	private Long startNum;
	private Long lastNum;

	private Long totalPage;

	public void makeRow() {

		this.startRow = (this.getPn() - 1) * this.getPerPage() + 1;
		this.lastRow = this.getPn() * this.getPerPage();

	}

	public void makeNum(Long totalCount) {
		// 1. totalCount
		// Long totalCount=215L;

		// 2. totalCOunt
		totalPage = totalCount / this.getPerPage();
		if (totalCount % this.getPerPage() != 0) {
			totalPage++;
		}

		// 3. totalBlock 구하기
		Long totalBlock = totalPage / this.getPerBlock();
		if (totalPage % this.getPerBlock() != 0) {
			totalBlock++;
		}

		// 4. pn으로 curBlock 구하기
		if (totalPage < this.getPn()) {
			this.setPn(totalPage);
		}
		Long curBlock = this.getPn() / this.getPerBlock();
		if (this.getPn() % this.getPerBlock() != 0) {
			curBlock++;
		}

		// 5. curBlock으로 시작번호와 마지막 번호 구하기
		this.startNum = (curBlock - 1) * this.getPerBlock() + 1;
		this.lastNum = curBlock * this.getPerBlock();

		if (curBlock == totalBlock) {
			this.lastNum = totalPage;
		}

	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if (this.search == null) {
			this.search="";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public Long getPerPage() {
		if (this.perPage == null || this.perPage == 0) {
			this.perPage = 10L;
		}
		return perPage;
	}
	
	

	public Long getPerBlock() {
		this.perBlock=5L;
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPn() {
		if (this.pn == null || this.pn <= 0) {
			this.pn = 1L;
		}
		return pn;
	}

	public void setPn(Long pn) {
		this.pn = pn;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

}
