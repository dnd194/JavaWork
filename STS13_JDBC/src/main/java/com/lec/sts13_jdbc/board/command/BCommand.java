package com.lec.sts13_jdbc.board.command;

import org.springframework.ui.Model;

public interface BCommand {
	void execute(Model model);
}
