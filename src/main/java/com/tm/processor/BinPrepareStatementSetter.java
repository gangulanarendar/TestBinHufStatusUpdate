package com.tm.processor;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.tm.model.BinHufStatus;

public class BinPrepareStatementSetter implements ItemPreparedStatementSetter<BinHufStatus> {
    @Override
    public void setValues(BinHufStatus bin, PreparedStatement ps) throws SQLException {


    	ps.setInt(1,bin.getInt_binid());
		ps.setInt(2,bin.getInt_countryId());
		ps.setString(3,bin.getChr_status());
		ps.setString(4,bin.getStr_agent_name());
		ps.setDate(5,bin.getLast_updated());
		ps.setString(6, bin.getIssuingBank());
		/*
		 * ps.setInt(1, user.getId()); ps.setString(2, user.getName());
		 */
    }
}