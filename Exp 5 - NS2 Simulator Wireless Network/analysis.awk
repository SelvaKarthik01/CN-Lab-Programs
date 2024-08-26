# Analysis script for NS2 simulation trace files to calculate throughput, number of packets, and number of packets dropped

# Variables to store total packets received, dropped packets, total data bytes, and start and end times
BEGIN {
    total_packets_received = 0
    total_packets_dropped = 0
    total_data_bytes = 0
    start_time = -1
    end_time = 0
}

# Process each line of the trace file
{
    if ($1 == "r") {  # 'r' indicates a packet receive event
        total_packets_received += 1
        packet_size = $6   # Assuming packet size is in the 6th field
        total_data_bytes += packet_size
        if (start_time == -1) {
            start_time = $2  # Capture start time from the first packet
        }
        end_time = $2      # Update end time with the most recent packet timestamp
    } else if ($1 == "d") {  # 'd' indicates a packet dropped event
        total_packets_dropped += 1
    }
}

# End block to calculate and output statistics
END {
    # Calculate simulation duration
    simulation_duration = end_time - start_time

    if (simulation_duration > 0) {
        throughput = (total_data_bytes * 8) / simulation_duration  # Throughput in bits per second
    } else {
        throughput = 0
    }

    print "Total packets received: " total_packets_received
    print "Total packets dropped: " total_packets_dropped
    print "Total data bytes received: " total_data_bytes
    print "Throughput (bits per second): " throughput
}

