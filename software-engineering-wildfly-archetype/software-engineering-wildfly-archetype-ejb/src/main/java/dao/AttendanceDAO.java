// @Author Sylvia & Daniel

package dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Attendance;
import entities.Event;
import entities.User;

@Stateless
@Local(AttendanceDAOLocal.class)
public class AttendanceDAO implements AttendanceDAOLocal {

	@PersistenceContext
	private EntityManager em;

	// EventParticipant
	@Override
	public int cancelAttendance(Event event, User user) {
		Event e = em.find(Event.class, event);
		if (e.getEventOwner() != user.getEmail()) {
			em.merge(e);
		}
		return 1;
	}

	@Override
	public int requestAttendance(Event event, User user) {
		Event e = em.find(Event.class, event);
		if (e.getEventOwner() != user.getEmail()) {
			Attendance a = new Attendance();
			em.persist(a);
		}
		return 3;
	}

	// Eventowner

	@Override
	public void confirmAttendance(Event event, User user, User userAendern) {
		Event e = em.find(Event.class, event);
		if (e.getEventOwner() == user.getEmail()) {
			Attendance a = em.find(Attendance.class, userAendern);
			a.setStatus(2);
			em.merge(a);
		}

	}

	@Override
	public void rejectAttendance(Event event, User user, User userAendern) {
		Event e = em.find(Event.class, event);
		if (e.getEventOwner() == user.getEmail()) {
			Attendance a = em.find(Attendance.class, userAendern);
			a.setStatus(4);
			em.merge(a);
		}

	}

	@Override
	public Attendance findAttendanceById(int attendanceId) {
		return em.find(Attendance.class, attendanceId);
	}
}