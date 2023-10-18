package com.Biniamlab.OLGSimulation.Repository;

import com.Biniamlab.OLGSimulation.DataModel.WinningNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WinningNumberRepository extends JpaRepository<WinningNumber, UUID> {
}
