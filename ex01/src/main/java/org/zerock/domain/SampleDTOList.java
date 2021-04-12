package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data //  setter & getter & toString() & 생성자를 자동으로 만드는 어노테이션
public class SampleDTOList {
	
	private List<SampleDTO> list;
	
	public SampleDTOList() {
		list = new ArrayList<SampleDTO>();
	}

}
