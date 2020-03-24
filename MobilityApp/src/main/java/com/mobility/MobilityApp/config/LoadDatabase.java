package com.mobility.MobilityApp.config;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mobility.MobilityApp.entity.Bus;
import com.mobility.MobilityApp.entity.Itinerary;
import com.mobility.MobilityApp.helper.DataHelper;
import com.mobility.MobilityApp.repository.BusRepository;
import com.mobility.MobilityApp.repository.ItineraryRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(BusRepository busRepository, ItineraryRepository itineraryRepository)
			throws IOException, InterruptedException, URISyntaxException {

		DataHelper dataHelper = new DataHelper();

		List<Bus> buses = dataHelper
				.getBussesFromJson("http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%25&t=o");

		buses.stream().forEach(bus -> {

			log.info("Preloading " + busRepository.save(bus));

			Itinerary itinerary;

			try {
				itinerary = dataHelper.getItineraryFromJson(
						"http://www.poatransporte.com.br/php/facades/process.php?a=il&p=" + bus.getId());

				log.info("Preloading " + itineraryRepository.save(itinerary));

			} catch (IOException | InterruptedException | URISyntaxException e) {
				e.printStackTrace();
			}
		});

		return args -> {
		};
	}
}
