package deaplearning.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.HandlerBase;

public class Split {

	public static void main(String[] args) {
		List<Q> qList = new ArrayList<Split.Q>();
		Split s = new Split();
		Split.Q q = s.new Q();
		q.setPkid(1L);
		q.setQulity(4L);
		Split.Q q1 = s.new Q();
		q1.setPkid(2L);
		q1.setQulity(4L);
		Split.Q q2 = s.new Q();
		q2.setPkid(3L);
		q2.setQulity(5L);
		qList.add(q);
		qList.add(q1);
		qList.add(q2);
		
		try {
			System.out.println(split(123L,qList));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Map<Long, Long> split(Long orderCount, List<Q> qList) throws Exception {
		Map<Long, Long> resultMap = new HashMap<Long, Long>();
		Long remaining = 0L;
		Long have = 0L;
		for (Q q : qList) {
			remaining = orderCount - q.getQulity();
			if (remaining <= 0) {
				resultMap.put(q.getPkid(), orderCount);
				break;
			} else {
				resultMap.put(q.getPkid(), q.getQulity());
			}
			have = orderCount - q.getQulity();
		}
		System.out.println(have);
		if(have > 0){
			throw new Exception("资源不够！！！！！！");
		}
		return resultMap;
	}
	
	class Q{
		private Long pkid;
		private Long qulity;
		public Long getPkid() {
			return pkid;
		}
		public void setPkid(Long pkid) {
			this.pkid = pkid;
		}
		public Long getQulity() {
			return qulity;
		}
		public void setQulity(Long qulity) {
			this.qulity = qulity;
		}
	}
}
