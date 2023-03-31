package com.te.sbs.service;

import java.util.List;

import com.te.sbs.dto.SportsFieldDto;
import com.te.sbs.entity.SportsField;

public interface SportsFieldService{

	SportsField addField(SportsFieldDto sportsFieldDto);

	List<SportsField> showField();

}
