package kz.daracademy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends ElasticsearchRepository<TaskEntity, String> {

    Page<TaskEntity> getTaskEntityByExecutorId (String executorId, Pageable pageable);

    Page<TaskEntity> getTaskEntityByInitiatorId (String initiatorId, Pageable pageable);

    TaskEntity getTaskEntityByTaskId(String taskId);

    void deleteTaskEntitiesByTaskId(String taskId);

    List<TaskEntity> getTaskEntitiesBy();


}
