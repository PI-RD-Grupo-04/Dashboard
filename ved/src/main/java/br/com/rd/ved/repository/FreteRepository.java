package br.com.rd.ved.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.model.Frete;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Integer>,  CrudRepository<Frete,Integer>{

}
