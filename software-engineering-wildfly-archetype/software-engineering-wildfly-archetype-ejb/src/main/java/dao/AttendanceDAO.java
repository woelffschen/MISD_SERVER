// @Author Sylvia & Daniel

package dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Attendance;
import entities.Event;
import entities.User;
import onlineService.NotAllowedException;

@Stateless
@Local(AttendanceDAOLocal.class)
public class AttendanceDAO implements AttendanceDAOLocal {

	@PersistenceContext
	private EntityManager em;

	// EventParticipant
	@Override
	public int cancelAttendance(Event event, User user) throws NotAllowedException {
		if (event.getEventOwner() != user.getEmail()) {
			Event e = this.em.find(Event.class, event.getEventId());
			Attendance attendance = null;

			for (Attendance a : e.getAttendanceList()) {
				if (a.getUser().getEmail().equals(user.getEmail())) {
					attendance = a;
					break;
				}
			}
			if (attendance != null) {
				attendance.setStatus(1);

				em.merge(attendance);

				return attendance.getStatus();
			} else {
				throw new NotAllowedException("Sie sind kein Teilnehmer des Events.");
			}
		}

		throw new NotAllowedException("Nur ein Teilnehmer darf seine Anmeldung stornieren.");
	}

	@Override
	public int requestAttendance(Event event, User user) throws NotAllowedException {
		if (event.getEventOwner() != user.getEmail()) {
			Event e = this.em.find(Event.class, event.getEventId());
			User u = this.em.find(User.class, user.getEmail());

			Attendance a = new Attendance(e, u);
			a.setStatus(3);
			em.persist(a);
			return a.getStatus();
		}

		throw new NotAllowedException("Nur der Besitzer darf Teilnehmer bestätigen.");
	}

	@Override
	public int confirmAttendance(Event event, User user, User userAendern) throws NotAllowedException {
		Event e = em.find(Event.class, event);
		if (e.getEventOwner() == user.getEmail()) {
			Attendance attendance = null;
			for (Attendance a : e.getAttendanceList()) {
				if (a.getUser().getEmail().equals(userAendern.getEmail())) {
					attendance = a;
					break;
				}
			}
			if (attendance != null) {
				attendance.setStatus(2);
				em.merge(attendance);

				return attendance.getStatus();
			} else {
				throw new NotAllowedException("Sie sind kein Teilnehmer des Events.");
			}
		} else {
			throw new NotAllowedException("Nur der Besitzer darf Teilnehmer bestätigen.");
		}
	}

	@Override
	public int rejectAttendance(Event event, User user, User userAendern) throws NotAllowedException {
		Event e = em.find(Event.class, event);
		if (e.getEventOwner() == user.getEmail()) {
			Attendance attendance = null;
			for (Attendance a : e.getAttendanceList()) {
				if (a.getUser().getEmail().equals(userAendern.getEmail())) {
					attendance = a;
					break;
				}
			}
			if (attendance != null) {
				attendance.setStatus(4);
				em.merge(attendance);

				return attendance.getStatus();
			} else {
				throw new NotAllowedException("Sie sind kein Teilnehmer des Events.");
			}
		} else {
			throw new NotAllowedException("Nur der Besitzer darf Teilnehmer bestätigen.");
		}
	}

	@Override
	public Attendance findAttendanceById(int attendanceId) {
		return em.find(Attendance.class, attendanceId);
	}
}