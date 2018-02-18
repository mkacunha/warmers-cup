package br.com.mkacunha.warmerscup.warmerscupserver.domain.worker;

import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    public WorkerDTO findByHash(String hash) {
        WorkerDTO worker = new WorkerDTO();
        worker.setName("Name " + hash);
        worker.setHash(hash);
        worker.setEmail(hash + "@email.com");
        return worker;
    }

}
