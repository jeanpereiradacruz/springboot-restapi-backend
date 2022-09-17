package com.onsafety.restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onsafety.restapi.exception.UserNotFoundException;
import com.onsafety.restapi.model.Pessoa;
import com.onsafety.restapi.repository.PessoaRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class PessoaController {

	private final PessoaRepository pessoaRepository;
	
	public PessoaController(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	// Posting data
	@PostMapping("/pessoas")
	Pessoa newPessoa(@RequestBody @Valid Pessoa newPessoa) {
		return pessoaRepository.save(newPessoa);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	
	//Getting data
	@GetMapping("/pessoas")
	List<Pessoa> getAllPessoas(){
		return pessoaRepository.findAll();
	}
	
	// Getting a single user 
	@GetMapping("/pessoas/{id}")
	Pessoa getPessoaById(@PathVariable Long id) {
		return pessoaRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
	}
	
	//Update a single user 
    @PutMapping("/pessoas/{id}")
    Pessoa updatePessoa(@RequestBody @Valid Pessoa newPessoa, @PathVariable Long id) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(newPessoa.getNome());
                    pessoa.setEmail(newPessoa.getEmail());
                    pessoa.setCpf(newPessoa.getCpf());
                    pessoa.setDataNascimento(newPessoa.getDataNascimento());
                    return pessoaRepository.save(pessoa);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    // Deleting a user
    @DeleteMapping("/pessoas/{id}")
    String deletePessoa(@PathVariable Long id){
        if(!pessoaRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        pessoaRepository.deleteById(id);
        return  "Pessoa com o id "+id+" foi deletado com sucesso.";
    }

}
 