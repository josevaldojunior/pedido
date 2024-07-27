package br.com.tech.pedidos.domain.repository;

import br.com.tech.pedidos.domain.model.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Long> {
}
