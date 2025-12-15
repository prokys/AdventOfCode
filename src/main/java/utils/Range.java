package utils;

import java.util.Objects;

public class Range {

    private long start;
    private long end;

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public Range(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public Range(Range range) {
        this.start = range.getStart();
        this.end = range.getEnd();
    }

    public long getSize() {
        return this.end - this.start + 1;
    }

    @Override
    public String toString() {
        return "Range{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public boolean mergeRange(Range rangeToMerge){

        if (this.start == rangeToMerge.getStart() && this.end == rangeToMerge.getEnd()) {
            return false;
        }

        if (this.end < rangeToMerge.getStart() || rangeToMerge.getEnd() < this.start) {
            return false;
        }

        this.start = Math.min(this.start, rangeToMerge.getStart());
        this.end   = Math.max(this.end, rangeToMerge.getEnd());
        return true;
    }
}
