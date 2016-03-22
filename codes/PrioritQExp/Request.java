
public class Request implements Comparable<Request>
{
	private String requestName = "";
	private int priorityStatus = 0;
			/**
		 * @param requestName
		 * @param priorityStatus
		 */
    public Request(String requestName, int priorityStatus)
    {
		    this.requestName = requestName;
		    this.priorityStatus = priorityStatus;
    }
    
    @Override
    public int compareTo(Request otherRequest)
    {
		    return Integer.compare(priorityStatus, otherRequest.priorityStatus);
    }

		@Override
    public String toString()
    {
		    return "Request [requestName= " + requestName + ", priorityStatus=" + priorityStatus + "]";
    }
		
}