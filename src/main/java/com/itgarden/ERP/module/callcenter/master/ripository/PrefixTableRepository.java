package com.itgarden.ERP.module.callcenter.master.ripository;

import com.itgarden.ERP.module.callcenter.master.model.PrefixTable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author libertyerp_local
 */
public interface PrefixTableRepository extends JpaRepository<PrefixTable, Long> {

    List<PrefixTable> findByConfigIdId(Long configId);
}
