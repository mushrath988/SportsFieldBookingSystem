package com.te.sbs.serviceimpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.sbs.dto.SportsFieldDto;
import com.te.sbs.entity.SportsField;
import com.te.sbs.repository.SportsFieldRepository;
import com.te.sbs.service.SportsFieldService;

@Service
public class SportsFieldServiceImpl implements SportsFieldService {
	@Autowired
	private SportsFieldRepository sportsFieldRepository;

	@Override
	public SportsField addField(SportsFieldDto sportsFieldDto) {
		SportsField sportsField = new SportsField();
		BeanUtils.copyProperties(sportsFieldDto, sportsField);
		sportsFieldRepository.save(sportsField);
		return sportsField;
	}

	@Override
	public List<SportsField> showField() {
		List<SportsField> sflist = sportsFieldRepository.findAll();
		return sflist;
	}

}
