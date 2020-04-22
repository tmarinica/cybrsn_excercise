package com.pokeapi.model;

import java.io.Serializable;
import java.util.List;

public class BerriesNamesWithUrlsResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer count;
	private String next;
	private String previous;
	private List<BerryNameWithUrl> results;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public List<BerryNameWithUrl> getResults() {
		return results;
	}

	public void setResults(List<BerryNameWithUrl> results) {
		this.results = results;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + ((previous == null) ? 0 : previous.hashCode());
		result = prime * result + ((results == null) ? 0 : results.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BerriesNamesWithUrlsResponse other = (BerriesNamesWithUrlsResponse) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (previous == null) {
			if (other.previous != null)
				return false;
		} else if (!previous.equals(other.previous))
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BerriesResponse [count=");
		builder.append(count);
		builder.append(", next=");
		builder.append(next);
		builder.append(", previous=");
		builder.append(previous);
		builder.append(", results=");
		builder.append(results);
		builder.append("]");
		return builder.toString();
	}

}
