package bs.student_manage;

import bs.student_manage.dto.StudentDto;

@FunctionalInterface
public interface StudentInterface {
	boolean check(StudentDto s, Object o);
}
