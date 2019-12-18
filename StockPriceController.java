package com.cognizant.stockmarket.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.stockmarket.entity.Company;
import com.cognizant.stockmarket.entity.StockPrice;
import com.cognizant.stockmarket.service.StockPriceService;

@RestController
@RequestMapping("/stockprice")
public class StockPriceController {

	@Autowired
	private StockPriceService stockPriceService;

	@PostMapping()
	public void addStockPrice(@RequestBody StockPrice sp) {
		try {
			stockPriceService.addStockPrice(sp);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invlaid company");
		}
	}

	public List<StockPrice> addNewStockPrice(StockPrice spc) {
		return Collections.EMPTY_LIST;
	}

}
