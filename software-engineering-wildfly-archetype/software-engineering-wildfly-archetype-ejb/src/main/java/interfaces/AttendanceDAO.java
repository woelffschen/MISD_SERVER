// created by Sylvia & Daniel

package interfaces;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AttendanceDAO implements AttendanceInterface {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void confirmAttendance(int eventId, int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectAttendance(int eventId, int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestAttendance(int eventId, int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelAttendance(int eventId, int userId) {
		// TODO Auto-generated method stub
		
	}

}
