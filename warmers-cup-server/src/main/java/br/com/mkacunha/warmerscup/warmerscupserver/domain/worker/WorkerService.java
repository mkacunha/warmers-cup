package br.com.mkacunha.warmerscup.warmerscupserver.domain.worker;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.util.Objects.isNull;

@Service
public class WorkerService {

	private static final String URL = "http://192.168.208.164:32568/api/collaborator/getbyrfid/?rfid=%s";

	public WorkerDTO findByHash(String hash) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<WorkerDTO> user = restTemplate
				.exchange(String.format(URL, hash), HttpMethod.GET, null, new ParameterizedTypeReference<WorkerDTO>() {
				});

		if (isNull(user.getBody())) {
			throw new RuntimeException("Usuário não cadastrado na base de dados");
		}

		return user.getBody();
	}
}
