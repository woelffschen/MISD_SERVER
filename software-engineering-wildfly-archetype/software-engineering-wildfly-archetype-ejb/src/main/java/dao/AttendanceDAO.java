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
		if (!event.getEventOwner().equals(user.getEmail())) {
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
		if (!event.getEventOwner().equals(user.getEmail())) {
			Event e = this.em.find(Event.class, event.getEventId());
			User u = this.em.find(User.class, user.getEmail());
			
			/*
			 * ÄNDERUNG nur am Aufruf
			 */
			Attendance a = new Attendance();
			a.setUser(u);
			a.setEvent(e);
			a.setStatus(3);
			this.em.persist(a);
			return a.getStatus();
		}

		throw new NotAllowedException("Sie dürfen bei Ihrem eigenen Event keine Anfrage stellen.");
	}


	@Override
	public int confirmAttendance(Event event, User user, User userAendern) throws NotAllowedException {
		Event e = em.find(Event.class, event.getEventId());
		if (e.getEventOwner().equals(user.getEmail())) {
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
			throw new NotAllowedException("Nur der Event Veranstalter darf Teilnehmer bestätigen.");
		}
	}

	@Override
	public int rejectAttendance(Event event, User user, User userAendern) throws NotAllowedException {
		Event e = em.find(Event.class, event.getEventId());
		if (e.getEventOwner().equals(user.getEmail())) {
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
			throw new NotAllowedException("Nur der Event Veranstalter darf Teilnehmer ablehnen.");
		}
	}
	
	@Override
	public Attendance findAttendance(int eventId, String email) {
		Event event = em.find(Event.class, eventId);
		User user = em.find(User.class, email);

		Attendance result = null;

		try {
			result = em.createQuery("SELECT a FROM Attendance a WHERE a.event LIKE :event AND a.user LIKE :user",
					Attendance.class).setParameter("event", event).setParameter("user", user).getSingleResult();
		} catch (Exception e) {
			// Ignore
		}

		return result;
	}

	
}