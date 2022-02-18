package tn.esprit.spring.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Statistic;

@Service
public class ServiceStatisticImpl implements ServiceStatistic {

	@Override
	public Statistic CreateStatistic(List<Product> products) {
		// TODO Auto-generated method stub
		Statistic statistics = new Statistic();
		((Statistic) statistics).setCount(products.stream().count());
		((Statistic) statistics)
				.setAvg(BigDecimal.valueOf(products.stream().mapToDouble(t -> t.getPrice_prod()).average().orElse(0.0))
						.setScale(2, RoundingMode.HALF_UP));
		((Statistic) statistics)
				.setMin(BigDecimal.valueOf(products.stream().mapToDouble(t -> t.getPrice_prod()).min().orElse(0.0))
						.setScale(2, RoundingMode.HALF_UP));
		((Statistic) statistics)
				.setMax(BigDecimal.valueOf(products.stream().mapToDouble(t -> t.getPrice_prod()).max().orElse(0.0))
						.setScale(2, RoundingMode.HALF_UP));
		((Statistic) statistics).setSum(BigDecimal.valueOf(products.stream().mapToDouble(t -> t.getPrice_prod()).sum())
				.setScale(2, RoundingMode.HALF_UP));

		return (Statistic) statistics;
	}

}
