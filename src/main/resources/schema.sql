DROP TABLE IF EXISTS tbl_bin_hostility_status;
CREATE TABLE  tbl_bin_hostility_status (
 	int_binId INT NOT NULL,
	int_countryId INT NULL,
	chr_status varchar(1)  NULL,
	str_agent_name varchar(20)  NULL,
	last_updated datetime NOT NULL
) ;


DROP TABLE IF EXISTS tbl_bin_hostility_status2;
CREATE TABLE  tbl_bin_hostility_status2 ( 
 	int_binId INT NOT NULL,
	int_countryId INT NULL,
	chr_status varchar(1)  NULL,
	str_agent_name varchar(20)  NULL,
	last_updated datetime NOT NULL,
	str_issuing_bank varchar(255) NULL

) ;