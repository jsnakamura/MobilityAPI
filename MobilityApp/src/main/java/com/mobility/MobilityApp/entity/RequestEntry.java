package com.mobility.MobilityApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestEntry {

	double lat;
	double lng;
	double radius;
}
