package com.uom.cs.studentsystem.controller;

import com.uom.cs.studentsystem.form.CurriculumForm;
import com.uom.cs.studentsystem.model.CourseSelectionEntity;
import com.uom.cs.studentsystem.model.CurriculumEntity;
import com.uom.cs.studentsystem.model.TeacherCurriculumRelationEntity;
import com.uom.cs.studentsystem.repository.CurriculumEntityRepository;
import com.uom.cs.studentsystem.repository.TeacherCurriculumRelationEntityRepository;
import com.uom.cs.studentsystem.repository.TeacherEntityRepository;
import com.uom.cs.studentsystem.service.impl.ComputerScienceAdapterMathematics;
import com.uom.cs.studentsystem.service.impl.ComputerScienceServiceImpl;
import com.uom.cs.studentsystem.service.impl.CurriculumServiceImpl;
import com.uom.cs.studentsystem.service.impl.MathematicsServiceImpl;
import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.utils.ConstantUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @version 1.0 created by YIXUAN on 2022/4/28 16:37
 */
@Controller
public class CurriculumController {
//    @Autowired
//    private CurriculumServiceImpl curriculumServiceImpl;
//
//    @Autowired
//    private CurriculumEntityRepository curriculumEntityRepository;
//
//    @Autowired
//    private TeacherCurriculumRelationEntityRepository teacherCurriculumRelationEntityRepository;
//
//    @Autowired
//    private TeacherEntityRepository teacherEntityRepository;
//
//    @GetMapping("/computerScience")
//    public String computerScience(Model model, HttpServletRequest request) {
//        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
//        List<CurriculumEntity> curriculumEntityList = curriculumServiceImpl.queryCurriculumBySubject(ConstantUtils.COMPUTER_SCIENCE, student.getId());
//        model.addAttribute("curriculumList", curriculumEntityList);
//        model.addAttribute("url", "computerScience");
//        return "curriculum";
//    }
//
//    @GetMapping("/mathematics")
//    public String mathematics(Model model, HttpServletRequest request) {
//        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
//        List<CurriculumEntity> curriculumEntityList = curriculumServiceImpl.queryCurriculumBySubject(ConstantUtils.MATHEMATICS, student.getId());
//        model.addAttribute("curriculumList", curriculumEntityList);
//        model.addAttribute("url", "mathematics");
//        return "curriculum";
//    }
//
//    @GetMapping("/selectCourse/{url}/{id}")
//    public String selectCourse(@PathVariable String url, @PathVariable Integer id, Model model, HttpServletRequest request) {
//        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
//        CourseSelectionEntity courseSelectionEntity = new CourseSelectionEntity();
//        courseSelectionEntity.setCurriculumId(id);
//        courseSelectionEntity.setStudentId(Integer.parseInt(student.getId()));
//        curriculumServiceImpl.saveCourseSelection(courseSelectionEntity);
//        List<CurriculumEntity> curriculumEntityList = curriculumServiceImpl.queryCurriculumBySubject(ConstantUtils.COMPUTER_SCIENCE, student.getId());
//        model.addAttribute("curriculumList", curriculumEntityList);
//        return "redirect:/" + url;
//    }
//
//    @GetMapping("/deleteCourse/{id}")
//    public String deleteCourse(@PathVariable Integer id) {
//        curriculumServiceImpl.deleteCourse(id.longValue());
//        return "redirect:/studentSupport";
//    }
//
//    @PostMapping("/insert/computerScience")
//    public String insertComputerScience(CurriculumForm curriculumForm, Model model, HttpServletRequest request) {
//        CurriculumEntity curriculumEntity = new CurriculumEntity();
//        BeanUtils.copyProperties(curriculumForm, curriculumEntity);
//        curriculumEntity.setSubject(ConstantUtils.COMPUTER_SCIENCE);
//        ComputerScienceServiceImpl computerScienceService = new ComputerScienceServiceImpl(curriculumEntity, curriculumEntityRepository);
//        CurriculumEntity curriculumEntityDB = curriculumServiceImpl.insertComputerScience(computerScienceService);
//        TeacherCurriculumRelationEntity teacherCurriculumRelationEntity = new TeacherCurriculumRelationEntity();
//        teacherCurriculumRelationEntity.setCurriculumId(curriculumEntityDB.getId().intValue());
//        teacherCurriculumRelationEntity.setTeacherId(curriculumForm.getTeacherId());
//        teacherCurriculumRelationEntityRepository.save(teacherCurriculumRelationEntity);
//        model.addAttribute("teacherList", teacherEntityRepository.findAll());
//        return "redirect:/studentSupport";
//    }
//
//    @PostMapping("/insert/mathematics")
//    public String insertMathematics(CurriculumForm curriculumForm, Model model, HttpServletRequest request) {
//        CurriculumEntity curriculumEntity = new CurriculumEntity();
//        BeanUtils.copyProperties(curriculumForm, curriculumEntity);
//        curriculumEntity.setSubject(ConstantUtils.MATHEMATICS);
//        MathematicsServiceImpl mathematicsService = new MathematicsServiceImpl(curriculumEntity, curriculumEntityRepository);
//        ComputerScienceAdapterMathematics adapterMathematics = new ComputerScienceAdapterMathematics(mathematicsService);
//        CurriculumEntity curriculumEntityDB = curriculumServiceImpl.insertComputerScience(adapterMathematics);
//        TeacherCurriculumRelationEntity teacherCurriculumRelationEntity = new TeacherCurriculumRelationEntity();
//        teacherCurriculumRelationEntity.setCurriculumId(curriculumEntityDB.getId().intValue());
//        teacherCurriculumRelationEntity.setTeacherId(curriculumForm.getTeacherId());
//        teacherCurriculumRelationEntityRepository.save(teacherCurriculumRelationEntity);
//        model.addAttribute("teacherList", teacherEntityRepository.findAll());
//        return "redirect:/studentSupport";
//    }

    

}