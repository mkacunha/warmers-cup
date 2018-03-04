package br.com.mkacunha.warmerscup.warmerscupserver.domain.worker;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WorkerService {

	private static final String URL = "http://192.168.208.164:32568/api/collaborator/getbyname/?collaboratorName=";

	public WorkerDTO findByHash(String hash) {
        /*WorkerDTO worker = new WorkerDTO();
        worker.setName("Name " + hash);
        worker.setHash(hash);
        worker.setEmail(hash + "@email.com");
        return worker;*/

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<WorkerDTO> user = restTemplate
				.exchange(URL + "", HttpMethod.GET, null, new ParameterizedTypeReference<WorkerDTO>() {
				});
		return user.getBody();
	}
}
