package fr.hildenbrand.contactapi.dbaccess;

import org.springframework.data.repository.CrudRepository;

import fr.hildenbrand.contactapi.model.Skill;

public interface SkillRepository extends CrudRepository<Skill, Long>{

}
