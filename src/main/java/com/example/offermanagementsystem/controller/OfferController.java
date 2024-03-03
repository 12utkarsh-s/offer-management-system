package com.example.offermanagementsystem.controller;

import com.example.offermanagementsystem.repository.Repository;
import com.example.offermanagementsystem.dto.offerMetadata.ComputationalStrategy;
import com.example.offermanagementsystem.dto.offerMetadata.EligibilityCriteria;
import com.example.offermanagementsystem.dto.offerMetadata.Offer;
import com.example.offermanagementsystem.dto.offerMetadata.criteriaImpl.AmountEligibilityCriteria;
import com.example.offermanagementsystem.dto.offerMetadata.criteriaImpl.CityEligibilityCriteria;
import com.example.offermanagementsystem.dto.offerMetadata.criteriaImpl.CompositeAndCriteria;
import com.example.offermanagementsystem.dto.offerMetadata.strategyImpl.CappedPercentageComputationalStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offer")
public class OfferController {

  @Autowired private Repository repository;

  @PostMapping("/create")
  public Boolean createOffer() {

    EligibilityCriteria amountEligibilityCriteria = new AmountEligibilityCriteria(5000);
    EligibilityCriteria cityEligibilityCriteria = new CityEligibilityCriteria("Bangalore");
    EligibilityCriteria eligibilityCriteria =
        new CompositeAndCriteria(amountEligibilityCriteria, cityEligibilityCriteria);

    ComputationalStrategy computationalStrategy = new CappedPercentageComputationalStrategy(500, 2);
    Offer offer = new Offer(eligibilityCriteria, computationalStrategy);

    repository.addOffer(offer);
    return true;
  }
}
