package com.acikoleji.adminpanel.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.acikoleji.adminpanel.entity.Student;
import com.acikoleji.adminpanel.entity.Sinav;
import com.acikoleji.adminpanel.model.GetSinavByTypeDTO;
import com.acikoleji.adminpanel.model.StudentDTO;
import com.acikoleji.adminpanel.model.SınavDTO;
import com.acikoleji.adminpanel.repository.SinavRepository;
import com.acikoleji.adminpanel.response.CreateSinavResponse;
import com.acikoleji.adminpanel.response.DeleteSinavResponse;
import com.acikoleji.adminpanel.response.Response;
import com.acikoleji.adminpanel.response.UpdateSinavResponse;
import com.acikoleji.adminpanel.service.SinavService;
import com.acikoleji.adminpanel.util.CheckUtils;
import com.acikoleji.adminpanel.util.MapperUtils;

@Service
public class SinavServiceImpl implements SinavService {

	private final SinavRepository sinavRepository;

	public SinavServiceImpl(SinavRepository sinavRepository) {
		this.sinavRepository = sinavRepository;
	}

	@Override
	public GetSinavByTypeDTO findBySinavType(String type) {
		Sinav sinav = sinavRepository.findByTipi(type);
		return new GetSinavByTypeDTO(MapperUtils.mapToGetSinavByTypeSTudentDTOs(sinav.getStudents()));
	}

	@Override
	public List<SınavDTO> findActiveExamns(Date date) {
		List<Sinav> activeExamns = sinavRepository.findActiveExamns(date);
		if (!activeExamns.isEmpty()) {
			List<SınavDTO> sinavDTOs = new ArrayList<>();
			for (Sinav sınav : activeExamns) {
				sinavDTOs.add(MapperUtils.mapToSinavDTO(sınav));
			}
			return sinavDTOs;
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public Response createSinav(SınavDTO sinavDTO) {
		Sinav findBySinavType = sinavRepository.findByTipi(sinavDTO.getTipi());
		Response sinavResponse = new CreateSinavResponse();
		if (CheckUtils.isNull(findBySinavType)) {
			Sinav savedSinav = sinavRepository.save(MapperUtils.mapToSinav(sinavDTO));
			if (CheckUtils.isNotNull(savedSinav)) {
				sinavResponse.setSuccess(Boolean.TRUE);
				sinavResponse.setMessage(savedSinav.getTipi() + " basari ile olusturulmustur");
			} else {
				sinavResponse.setSuccess(Boolean.FALSE);
				sinavResponse.setMessage(sinavDTO.getTipi() + " olusturlamadi");
			}
		} else {
			sinavResponse.setSuccess(Boolean.FALSE);
			sinavResponse.setMessage(sinavDTO.getTipi() + " daha onceden olusturulmustur. "
					+ "Lutfen daha onceden var olmayan bir kayit ekleyiniz");
		}
		return sinavResponse;
	}

	@Override
	public Response updateSinav(SınavDTO sinavDTO) {
		Sinav findBySinavType = sinavRepository.findByTipi(sinavDTO.getTipi());
		Response sinavResponse = new UpdateSinavResponse();
		if (CheckUtils.isNotNull(findBySinavType)) {
			Sinav savedSinav = sinavRepository.save(MapperUtils.mapToSinav(sinavDTO));
			if (CheckUtils.isNotNull(savedSinav)) {
				sinavResponse.setSuccess(Boolean.TRUE);
				sinavResponse.setMessage(savedSinav.getTipi() + " basari ile guncellenmistir");
			}
		} else {
			sinavResponse.setSuccess(Boolean.FALSE);
			sinavResponse.setMessage(sinavDTO.getTipi() + " guncellenemedi");
		}
		return sinavResponse;
	}

	@Override
	public Response deleteSinav(Long id) {
		Response sinavResponse = new DeleteSinavResponse();
		Optional<Sinav> findById = sinavRepository.findById(id);
		if (findById.isPresent()) {
			sinavRepository.delete(findById.get());
			sinavResponse.setSuccess(Boolean.TRUE);
			sinavResponse.setMessage(" Silme islemi basarili");

		} else {
			sinavResponse.setSuccess(Boolean.FALSE);
			sinavResponse.setMessage(" Silme islemi basarisiz");
		}
		return sinavResponse;
	}

	@Override
	public Boolean isExistActiveExams() {
		List<Sinav> findActiveExamns = sinavRepository.findActiveExamns(new Date());
		return !findActiveExamns.isEmpty();
	}

	@Override
	public List<StudentDTO> findStudentsByType(String type) {
		List<StudentDTO>  studentDTOs = new ArrayList<>();
		Sinav sinav = sinavRepository.findByTipi(type);
		List<Student> students = sinav.getStudents();
		for (Student student : students) {
			studentDTOs.add(MapperUtils.mapToStudentDTO(student));
		}
		return studentDTOs;
	}

	@Override
	public List<SınavDTO> getAll() {
		return MapperUtils.mapToSinavDTOs(sinavRepository.findAll());
	}

	@Override
	public List<Sinav> findActiveSinav(Date date) {
		return sinavRepository.findActiveExamns(date);
	}
}
